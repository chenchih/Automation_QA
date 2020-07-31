/// <reference types="Cypress" />
describe('My First Test Suite', function() {
    it('My FirstTest Case', function() {
    //check box
    cy.visit(' https://rahulshettyacademy.com/AutomationPractice/');
    cy.get('#checkBoxOption1').check().should('be.checked').and('have.value','option1')   
    cy.get('#checkBoxOption1').uncheck().should('not.be.checked')   
    cy.get('input[type="checkbox"]').check(['option2','option3'])
    //static dropdown
    cy.get('select').select('option2').should('have.value','option2')
    //dyanamic dropdown
    cy.get('#autocomplete').type('ind')
    cy.get(' .ui-menu-item div').each(($el, index, $list)=>{
        if ($el.text()=="India")
        {
            $el.click()
        }
        })

//autocomplete
cy.get('#autocomplete').should('have.value','India')
//visible invislble
cy.get('#displayed-text').should('be.visible')
cy.get('#hide-textbox').click()
cy.get('#displayed-text').should('not.be.visible')
cy.get('#show-textbox').click()
cy.get('#displayed-text').should('be.visible')
//radio
cy.get('[value="radio2"]').check().should('be.checked')


 })       
    })