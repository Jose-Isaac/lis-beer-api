/// <reference types="cypress" />
import { v4 as uuidV4 } from "uuid"

describe('Login', () => {
  let payload = {
    fantasyName: 'Another Store ' + uuidV4(),
    email: 'store' + uuidV4() + '@example.com',
    password: 'password456',
    phoneNumber: '123456789',
    address: {
      street: 'Main Street',
      city: 'My City',
      state: 'My State',
      postalCode: 54321987,
      country: 'My Country',
      houseNumber: 456,
      complement: 'Apartment 2A'
    }
  }

  before(() => {
    cy.request(
      'POST',
      '/stores/signup',
      payload
    )
  })

  it('Login with valid credentials', () => {
    cy.request(
      'POST',
      '/stores/signin',
      { email: payload.email, password: payload.password }
    ).then((response) => {
      expect(response.status).to.eq(200)
      expect(response.headers).to.have.property('authorization')
    })
  })

  it('should receive a status code 403 with invalid email credentials', () => {
    cy.request({
      method: 'POST',
      url: '/stores/signin',
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
      url: '/stores/login',
      body: { email: payload.email, password: "invalid_password" },
      failOnStatusCode: false
    }
    ).then((response) => {
      expect(response.status).to.eq(403)
    })
  })
})