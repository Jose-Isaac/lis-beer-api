/// <reference types="cypress" />

describe('Signup', () => {
  it('should sign up successfully', () => {
    cy.request({
      method: 'POST',
      url: '/users/signup',
      body: {
        username: 'fulano',
        email: 'fulano@example.com',
        password: '123456'
      }
    }).then((response) => {
      expect(response.status).to.eq(200)
      expect(response.body).to.have.property('id')
      expect(response.body).to.have.property('username', 'fulano')
      expect(response.body).to.have.property('email', 'fulano@example.com')
    })
  })

  it('should return 409 status code and error message when email already exists', () => {
    cy.request({
      method: 'POST',
      url: '/users/signup',
      body: {
        username: 'fulano2',
        email: 'fulano@example.com',
        password: '123456'
      },
      failOnStatusCode: false
    }).then((response) => {
      expect(response.status).to.eq(409)
      expect(response.body).to.have.property('message', 'Email or username already exist!')
    })
  })

  it('should return 409 status code and error message when username already exists', () => {
    cy.request({
      method: 'POST',
      url: '/users/signup',
      body: {
        username: 'fulano',
        email: 'fulano2@example.com',
        password: '123456'
      },
      failOnStatusCode: false
    }).then((response) => {
      expect(response.status).to.eq(409)
      expect(response.body).to.have.property('message', 'Email or username already exist!')
    })
  })
});