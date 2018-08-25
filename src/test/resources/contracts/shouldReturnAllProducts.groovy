import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "should_return_all_products_groovy"
    request {
        method GET()
        url("/products")
    }
    response {
        body(file("response.json"))
        status(200)
    }
}