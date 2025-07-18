import React from 'react';
import { Container, Row, Col, Button, Table, Image } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { removeFromCart, updateQuantity, clearCart } from '../../application/cart/cartSlice';
import Header from '../components/Header';
import Footer from '../components/Footer';
import { Link } from 'react-router-dom';

const CartPage = () => {
  const dispatch = useDispatch();
  const cart = useSelector((state) => state.cart);

  const handleRemoveFromCart = (id) => {
    dispatch(removeFromCart(id));
  };

  const handleUpdateQuantity = (id, quantity) => {
    if (quantity < 1) return;
    dispatch(updateQuantity({ id, quantity }));
  };

  const handleClearCart = () => {
    dispatch(clearCart());
  };

  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />
      <Container className="my-5 flex-grow-1">
        <h1 className="text-center mb-4">Your Shopping Cart</h1>

        {cart.items.length === 0 ? (
          <div className="text-center">
            <p>Your cart is empty.</p>
            <Button variant="primary" as={Link} to="/products">Continue Shopping</Button>
          </div>
        ) : (
          <>
            <Table striped bordered hover responsive>
              <thead>
                <tr>
                  <th>Product</th>
                  <th>Price</th>
                  <th>Quantity</th>
                  <th>Total</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {cart.items.map((item) => (
                  <tr key={item.id}>
                    <td>
                      <div className="d-flex align-items-center">
                        <Image src={item.image} thumbnail style={{ width: '50px', height: '50px', objectFit: 'cover', marginRight: '10px' }} />
                        {item.name}
                      </div>
                    </td>
                    <td>${item.price}</td>
                    <td>
                      <Form.Control
                        type="number"
                        value={item.quantity}
                        onChange={(e) => handleUpdateQuantity(item.id, parseInt(e.target.value))}
                        min="1"
                        style={{ width: '70px' }}
                      />
                    </td>
                    <td>${item.totalPrice.toFixed(2)}</td>
                    <td>
                      <Button variant="danger" size="sm" onClick={() => handleRemoveFromCart(item.id)}>
                        Remove
                      </Button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>

            <Row className="justify-content-end mt-4">
              <Col xs={12} md={4} className="text-end">
                <h4>Total Items: {cart.totalQuantity}</h4>
                <h3>Cart Total: ${cart.totalAmount.toFixed(2)}</h3>
                <Button variant="success" className="me-2" as={Link} to="/checkout">
                  Proceed to Checkout
                </Button>
                <Button variant="outline-danger" onClick={handleClearCart}>
                  Clear Cart
                </Button>
              </Col>
            </Row>
          </>
        )}
      </Container>
      <Footer />
    </div>
  );
};

export default CartPage;
