package com.gb.angularexample.service.cart;

import com.gb.angularexample.dto.CartDto;
import com.gb.angularexample.dto.ProductDto;
import com.gb.angularexample.model.Product;
import com.gb.angularexample.model.User;
import com.gb.angularexample.service.ProductService;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@SessionScope
@RequiredArgsConstructor
@Data
public class Cart {

    private Integer totalSum;
    private final ProductService productService;
    private List<CartPosition> positions = new ArrayList<>();


    @PostConstruct
    public void init() {
        this.positions = new ArrayList<>();
        this.totalSum  = 0;
    }

    public void addItem(Long productId) {

        ProductDto product = productService.getById(productId);

        CartPosition position = positions.stream().filter(p->p.getProduct().getId().equals(product.getId())).findFirst().orElse(null);

        if (position == null) {
            positions.add(new CartPosition(product, 1, product.getPrice()));
        }
        else {
            position.setQuantity(position.getQuantity() + 1);
        }

        recalculateTotalSum();
    }

    public void deleteItem(Long productId) {
        CartPosition position = positions.stream().filter(p->p.getProduct().getId().equals(productId)).findFirst().orElse(null);
        if (!Objects.isNull(position)) {
            if (position.getQuantity() > 1) {
                position.setQuantity(position.getQuantity() - 1);
            }
            else {
                this.positions.remove(position);
            }
            recalculateTotalSum();
        }
    }

    public void clear() {
        this.totalSum = 0;
        this.positions.clear();
    }

    public CartDto getDto() {
        return new CartDto(this.totalSum, this.positions);
    }

    private void recalculateTotalSum() {
        this.totalSum = this.positions.stream().mapToInt(CartPosition::getSum).sum();
    }

}
