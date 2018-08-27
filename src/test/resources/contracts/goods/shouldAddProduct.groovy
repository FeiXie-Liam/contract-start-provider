import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "should_add_a_goods_groovy"
    request {
        method POST()
        headers {
//            header "Content-type" : "application/json"
            contentType(applicationJson())
        }
        body(file("request.json"))
        url("/goods")
    }
    response {
        status(201)
    }
}