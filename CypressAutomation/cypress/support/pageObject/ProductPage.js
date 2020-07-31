class ProductPage
{
checkButton()
{
return cy.get('#navbarResponsive > .navbar-nav > .nav-item > .nav-link')
}

checkout(){
    
    return cy.get(':nth-child(4) > :nth-child(5) > .btn')

}

country(){
   
    return cy.get(' #country')

}

}
export default ProductPage;