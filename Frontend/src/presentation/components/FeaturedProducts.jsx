import React from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';

const products = [
  {
    id: 1,
    name: 'Luxury Sedan',
    image: 'https://via.placeholder.com/400x250?text=Luxury+Sedan',
    price: '50,000',
    description: 'A sleek and powerful luxury sedan with advanced features.',
  },
  {
    id: 2,
    name: 'Sport SUV',
    image: 'https://via.placeholder.com/400x250?text=Sport+SUV',
    price: '45,000',
    description: 'Spacious and versatile sport utility vehicle, perfect for families.',
  },
  {
    id: 3,
    name: 'Electric Hatchback',
    image: 'https://via.placeholder.com/400x250?text=Electric+Hatchback',
    price: '35,000',
    description: 'Eco-friendly and efficient electric car for urban adventures.',
  },
  {
    id: 4,
    name: 'Classic Roadster',
    image: 'https://via.placeholder.com/400x250?text=Classic+Roadster',
    price: '70,000',
    description: 'Timeless design meets modern performance in this classic roadster.',
  },
];

const cardVariants = {
  hidden: { opacity: 0, y: 50 },
  visible: { opacity: 1, y: 0, transition: { duration: 0.6, ease: 'easeOut' } },
  hover: { scale: 1.03, boxShadow: '0 8px 25px rgba(0,0,0,0.15)', transition: { duration: 0.2 } },
};

const FeaturedProducts = () => {
  return (
    <Container className="my-4 py-4">
      <h2 className="text-center mb-4">Featured Products</h2>
      <Row className="g-4">
        {products.map((product, index) => (
          <Col key={product.id} xs={12} sm={6} md={3}>
            <motion.div
              variants={cardVariants}
              initial="hidden"
              whileInView="visible"
              viewport={{ once: true, amount: 0.3 }}
              whileHover="hover"
              transition={{ delay: index * 0.1 }}
            >
              <Card className="h-100 shadow-sm">
                <Card.Img variant="top" src={product.image} alt={product.name} style={{ height: '180px', objectFit: 'cover' }} />
                <Card.Body className="d-flex flex-column">
                  <Card.Title className="h6">{product.name}</Card.Title>
                  <Card.Text className="text-muted" style={{ minHeight: '40px', overflow: 'hidden', textOverflow: 'ellipsis', display: '-webkit-box', WebkitLineClamp: 2, WebkitBoxOrient: 'vertical' }}>
                    {product.description}
                  </Card.Text>
                  <Card.Text className="h5 text-primary fw-bold mt-2">
                    ${product.price}
                  </Card.Text>
                  <div className="d-flex justify-content-between mt-auto pt-2">
                    <Button variant="primary" size="sm" as={Link} to={`/products/${product.id}`}>
                      View Details
                    </Button>
                    <Button variant="outline-secondary" size="sm" onClick={() => dispatch(addToCart({ id: product.id, name: product.name, price: parseFloat(product.price.replace(',', '')), image: product.image }))}>
                      Add to Cart
                    </Button>
                  </div>
                </Card.Body>
              </Card>
            </motion.div>
          </Col>
        ))}
      </Row>
    </Container>
  );
};

export default FeaturedProducts;
