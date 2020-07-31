/// <reference types="Cypress" />
describe('My First Test Suite', function() {
    it('My FirstTest Case', function() {
    //check box
    cy.visit(' https://rahulshettyacademy.com/AutomationPractice');
    
    cy.get('#opentab').then(function(el)
    {
        const url =el.prop('href')
        cy.log(url)
        cy.visit(url)
    })

})
    })