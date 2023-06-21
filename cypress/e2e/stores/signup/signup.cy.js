describe('Store Signup', () => {
  it('Cadastro de loja com sucesso', () => {
    cy.request('POST', '/stores/signup', {
      fantasyName: 'My Store',
      email: 'store@example.com',
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
      expect(response.status).to.eq(200);
    });
  });

  it('Cadastro de loja com email já existente', () => {
    cy.request({
      method: 'POST',
      url: '/stores/signup',
      body: {
        fantasyName: 'Another Store',
        email: 'store@example.com',
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
      },
      failOnStatusCode: false
    }).then((response) => {
      expect(response.status).to.eq(500);
    });
  });
});