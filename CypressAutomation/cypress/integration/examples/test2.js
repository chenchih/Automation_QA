/// <reference types="Cypress" />
describe('My First Test Suite', function() {
it('My FirstTest Case', function() {
 
        cy.visit(' https://rahulshettyacademy.com/seleniumPractise');
        cy.get('.search-keyword').type("ca")
        cy.wait(2000)
        cy.get('.products').as('productLocator')
        cy.get('@productLocator').find('.product').each(($el, index, $list)=>{
        const textVeg=$el.find('.product-name').text()
        //console.log('sf')
        
        if (textVeg.includes('Cashews'))
        {
        $el.find('button').click()
        }
        })

        cy.get('.cart-icon > img').click()
        cy.contains('PROCEED TO CHECKOUT').click()
        cy.get('Place Order').click()

    })
})

