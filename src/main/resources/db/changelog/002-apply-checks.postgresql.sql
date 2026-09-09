-- liquibase formatted sql

-- changeset czyrnia:constraint-products-stock-zero-or-higher
ALTER TABLE products 
ADD CONSTRAINT products_stock_zero_or_higher
CHECK (stock >= 0);

-- changeset czyrnia:constraint-product-margin-between-zero-and-a-hundred
ALTER TABLE products
ADD CONSTRAINT product_margin_between_zero_and_a_hundred
CHECK (margin >= 0 AND margin <= 100);

-- changeset czyrnia:constraint-purchase-inv-detail-buys-more-than-zero-products
ALTER TABLE purchase_invoice_details
ADD CONSTRAINT purchased_quantity_bigger_than_zero
CHECK (quantity > 0);

-- changeset czyrnia:constraint-sale-inv-detail-sells-more-than-zero-products
ALTER TABLE sale_invoice_details
ADD CONSTRAINT sold_quantity_bigger_than_zero
CHECK (quantity > 0);
