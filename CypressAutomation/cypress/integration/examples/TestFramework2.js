
/// <reference types="Cypress" />
import HomePage from '../../support/pageObject/HomePage'

import ProductPage from '../../support/pageObject/ProductPage';
describe('My Second Test Suite', function() 
{
    before(function() {
       cy.fixture('example').then(function(data){        
      this.data=data
      
       }) 
 })       

 it('My FirstTest Case', function()
 {
   
   const homePage= new HomePage()
   const productPage= new ProductPage()

   // cy.visit('https://rahulshettyacademy.com/angularpractice')
  // cy.visit(Cypress.env('url'))
  cy.visit(Cypress.env('url'))
    homePage.getEditBox().type(this.data.name)
    homePage.getGender().select(this.data.gender)
    homePage.getTwoWayDatabinding().should('have.value',this.data.name)
    homePage.getEditBox().should('have.attr','minlength','2' )
    homePage.getEntrepreneur().should('be.disabled' )
    //Cypress.config('defaultCommandTimeout', 8000)
    homePage.getShopTab().click()


    this.data.productName.forEach(function(element) {
   cy.selectProduct(element)
    });


    
   productPage.checkButton().click()
   var sum =0
   cy.get('tr td:nth-child(4) strong').each(($el, index, $list) => {
//cy.log ($el.text())
const amount=$el.text()
var res = amount.split (" ")
res=res[1].trim()

sum=Number(sum)+Number(res)

//actual:＄. 5000
//res[0]=$.
//res[1]=5000

   }).then(function(){
   cy.log (sum)
})
cy.get('h3 strong ').then(function(element)
{
const amount=element.text()
var res=amount.split(" ")
var total = res[1].trim()

//assertion: compare two value the sum we total up
expect(Number(total)).to.equal(sum)
})

   cy.contains('Checkout').click()
   cy.get('#country').type('India')
   cy.get('.suggestions > ul > li > a').click()
   cy.get('#checkbox2').click({force: true})
   //cy.get('.checkbox').click()
   cy.get('input[type="submit"]').click()
//assertion
  //cy.get('.alert').should('have.text','Success! Thank you! Your order will be delivered in next few weeks :-).')
  cy.get('.alert').then(function(element)
  {
  const actualText=element.text()
  expect(actualText.includes("Success!")).to.be.true

  })

   //productPage.checkout().click()
   //productPage.country().type('Taiwan')


   


 })
    })