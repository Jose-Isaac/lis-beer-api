/// <reference types="cypress" />
import { v4 as uuidV4 } from "uuid"

describe('Category Management', () => {
  let newUser = {
    email: 'user' + uuidV4() + '@exemplo.com',
    password: '123456',
    username: 'test-' + uuidV4()
  }
  let TOKEN

  before(() => {
    cy.request(
      'POST',
      '/users/signup',
      newUser
    )
    cy.request(
      'POST',
      '/users/signin',
      { email: newUser.email, password: newUser.password }
    ).then((response) => {
      TOKEN = response.headers.authorization
    })
  })

  it('Retrieving all categories', () => {
    cy.request({
      method: 'GET',
      url: '/categories',
      headers: { authorization: TOKEN }
    }).then((response) => {
        expect(response.status).to.eq(200)
        expect(response.body).to.be.an('array')
      })
  });

  it('Creating a new category', () => {
    let categoryName = `New Category ${uuidV4()}`
    cy.request({
      method: 'POST',
      url: '/categories',
      body: { name: categoryName },
      headers: { authorization: TOKEN }
    }).then((response) => {
      expect(response.status).to.eq(200)
      expect(response.body).to.have.property('name', categoryName)
      expect(response.body).to.have.property('evaluation', 0.0)
    })
  });

  it('Creating a duplicate category', () => {
    let categoryName = `New Category ${uuidV4()}`

    cy.request({
      method: 'POST',
      url: '/categories',
      body: { name: categoryName },
      headers: { authorization: TOKEN }
    })
    
    cy.request({
      method: 'POST',
      url: '/categories',
      body: { name: categoryName },
      headers: { authorization: TOKEN },
      failOnStatusCode: false
    })
    .then((response) => {
      expect(response.status).to.eq(409)
      expect(response.body).to.have.property('error', 'Conflict')
      expect(response.body).to.have.property('path', '/categories')
    })
  });
})
