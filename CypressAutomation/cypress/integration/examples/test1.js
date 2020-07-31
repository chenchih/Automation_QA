/// <reference types="Cypress" />
describe('My First Test Suite', function() {
it('My FirstTest Case', function() {
        cy.visit(' https://rahulshettyacademy.com/seleniumPractise/#/');
        
        cy.get('.search-keyword').type("ca")
        cy.wait(2000)
        cy.get('.product').should('have.length',5)
        cy.get('.product:visible').should('have.length',4)
        cy.get('.products').as('productLocator')
        cy.get('@productLocator').find('.product').should('have.length',4)

        //cy.get('@productLocator').find('.product').eq(2).contains('ADD TO CART').click()
        cy.get('@productLocator').find('.product').eq(2).contains('ADD TO CART').click().then(function()
        {
            console.log('sf')

        })
        
        cy.get('@productLocator').find('.product').each(($el, index, $list)=>{
        const textVeg=$el.find('.product-name').text()
        //console.log('sf')
        
        if (textVeg.includes('Cashews'))
        {
        $el.find('button').click()
        }

        })

        //assert if logo text is correctly
        cy.get('.brand').should('have.text', 'GREENKART')
        //this is to print in logs
        cy.get('.brand').then(function(logoelement)
        {
            
            cy.log(logoelement.text())
            
          
        }
        
        )
  
       // cy.log(logo.text())

 

    })
})

