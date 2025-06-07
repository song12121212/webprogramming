    package kr.ac.hansung.cse.hellospringdatajpa.entity;

    import jakarta.persistence.*;
    import jakarta.validation.constraints.DecimalMin;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import lombok.ToString;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @Entity
    @Table(name = "product")
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String brand;
        private String madeIn;

        @DecimalMin(value = "0.01", message = "가격은 0보다 커야 합니다.")
        private double price;

        public Product(String name, String brand, String madeIn, double price) {
            this.name = name;
            this.brand = brand;
            this.madeIn = madeIn;
            this.price = price;
        }
    }