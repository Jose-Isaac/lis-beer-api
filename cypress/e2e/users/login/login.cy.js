/// <reference types="cypress" />
import { v4 as uuidV4 } from "uuid"

describe('Login', () => {
  let payload = {
    email: 'user' + uuidV4() + '@exemplo.com',
    password: '123456',
    username: 'test-' + uuidV4()
  }

  before(() => {
    cy.request(
      'POST',
      '/users/signup',
      payload
    )
  })

  it('Login with valid credentials', () => {
    cy.request(
      'POST',
      '/users/signin',
      { email: payload.email, password: payload.password }
    ).then((response) => {
      expect(response.status).to.eq(200)
      expect(response.headers).to.have.property('authorization')
    })
  })

  it('should receive a status code 403 with invalid email credentials', () => {
    cy.request({
      method: 'POST',
      url: '/users/signin',
      body: { email: "invalid_email@exemple.com", password: payload.password },
      failOnStatusCode: false
    }
    ).then((response) => {
      expect(response.status).to.eq(403)
    })
  })

  it('should receive a status code 403 with invalid password credentials', () => {
    cy.request({
      method: 'POST',
      url: '/users/signin',
      body: { email: payload.email, password: "invalid_password" },
      failOnStatusCode: false
    }
    ).then((response) => {
      expect(response.status).to.eq(403)
    })
  })
})