/// <reference types="Cypress" />

describe('My Second Test Suite', function() 
{
    before(function() {
       cy.fixture('example').then(function(data){        
      this.data=data
      
       }) 
 })       

 it('My FirstTest Case', function()
 {
  
    cy.visit('https://rahulshettyacademy.com/angularpractice')

    //cy.get('input[name="name"]:nth-child(2)').type("ChenChih")
    cy.get('input[name="name"]:nth-child(2)').type(this.data.name)
    //using cypress runner method
    //cy.get(':nth-child(1) > .form-control').type("ChenChih")
    cy.get('select').select(this.data.gender)

    //validate 1:
    cy.get(':nth-child(4) > .ng-untouched').should('have.value',this.data.name )
    // validate 2
    cy.get('input[name="name"]:nth-child(2)').should('have.attr','minlength','2' )
    //validate3
    cy.get('#inlineRadio3').should('be.disabled')
    
    cy.get(':nth-child(2) > .nav-link').click()
  
    this.data.productName.forEach(function(element) {
      cy.selectProduct(element)
    });
    
   


 })
    })