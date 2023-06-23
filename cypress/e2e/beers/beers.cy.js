/// <reference types="cypress" />
import { v4 as uuidV4 } from "uuid"

describe('Gerenciamento de Cervejas', () => {
  let newUser = {
    email: 'user' + uuidV4() + '@exemplo.com',
    password: '123456',
    username: 'test-' + uuidV4()
  }
  let TOKEN
  let STORE_ID
  let CATEGORY_ID
  let BEER_ID

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

    cy.request('POST', '/stores/signup', {
      fantasyName: 'My Store' + uuidV4(),
      email: 'store' + uuidV4() + '@example.com',
      password: 'password123',
      phoneNumber: '987654321',
      address: {
        street: 'Main Street',
        city: 'My City',
        state: 'My State',
        postalCode: 12345678,
        country: 'My Country',
        houseNumber: 123,
        complement: 'Apartment 4B'
      }
    }).then((response) => {
      STORE_ID = response.body.id
    })
  })

  before(() => {
    let categoryName = `New Category ${uuidV4()}`
    cy.request({
      method: 'POST',
      url: '/categories',
      body: { name: categoryName },
      headers: { authorization: TOKEN }
    }).then((response) => {
      CATEGORY_ID = response.body.id
    }) 
  })

  it('Recuperar todas as cervejas', () => {
    cy.request({
      method: 'GET',
      url: '/beers',
      headers: { authorization: TOKEN }
    })
    .then((response) => {
      expect(response.status).to.eq(200)
      expect(response.body).to.be.an('array')
    })
  });

  it('Criar uma nova cerveja', () => {
    let newBeer = {
      "name": "IPA Beer" + uuidV4(),
      "brand": "Lisbeer Brewery",
      "price": "9.99",
      "photoUrl": "https://example.com/beer.jpg",
      "categories": [CATEGORY_ID],
      "storeId": STORE_ID
    }
    cy.request({
      method: 'POST',
      url: '/beers',
      body: newBeer,
      headers: { authorization: TOKEN }
    }).then((response) => {
      expect(response.status).to.eq(200)
      expect(response.body).to.have.property('name', newBeer.name)
      expect(response.body).to.have.property('brand', newBeer.brand)
      expect(response.body).to.have.property('price', 9.99)
      expect(response.body).to.have.property('photoUrl', newBeer.photoUrl)
      expect(response.body.categories).to.have.an('array')
      expect(response.body.categories[0].id).to.eq(CATEGORY_ID)
      expect(response.body).to.have.property('storeId', newBeer.storeId)

      BEER_ID = response.body.id
    })
  });

  it('Obter detalhes de uma cerveja por ID', () => {
    cy.request({
      method: 'GET',
      url: `/beers/${BEER_ID}`,
      headers: { authorization: TOKEN }
    }).then((response) => {
      expect(response.status).to.eq(200)
    })
  });

  it('Obter todas as cervejas por ID de categoria', () => {
    cy.request({
      method: 'GET',
      url: `/beers/categories/${CATEGORY_ID}`,
      headers: { authorization: TOKEN }
    }).then((response) => {
      expect(response.status).to.eq(200)
      expect(response.body).to.be.an('array')
    })
  });
});
