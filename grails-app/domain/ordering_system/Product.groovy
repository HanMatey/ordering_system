package ordering_system

class Product {
    String productName
    String description
    Double price
    Integer stockQty

    static constraints = {
        description nullable: true
    }
}
