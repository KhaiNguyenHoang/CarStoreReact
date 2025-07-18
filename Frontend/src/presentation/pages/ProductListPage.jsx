import React, { useState } from 'react';
import { Container, Row, Col, Form, Button, Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';
import Header from '../components/Header';
import Footer from '../components/Footer';

const products = [
  {
    id: 1,
    name: 'Luxury Sedan',
    image: 'https://via.placeholder.com/400x250?text=Luxury+Sedan',
    price: '50,000',
    description: 'A sleek and powerful luxury sedan with advanced features.',
    category: 'Sedans',
  },
  {
    id: 2,
    name: 'Sport SUV',
    image: 'https://via.placeholder.com/400x250?text=Sport+SUV',
    price: '45,000',
    description: 'Spacious and versatile sport utility vehicle, perfect for families.',
    category: 'SUVs',
  },
  {
    id: 3,
    name: 'Electric Hatchback',
    image: 'https://via.placeholder.com/400x250?text=Electric+Hatchback',
    price: '35,000',
    description: 'Eco-friendly and efficient electric car for urban adventures.',
    category: 'Hatchbacks',
  },
  {
    id: 4,
    name: 'Classic Roadster',
    image: 'https://via.placeholder.com/400x250?text=Classic+Roadster',
    price: '70,000',
    description: 'Timeless design meets modern performance in this classic roadster.',
    category: 'Sports Cars',
  },
  {
    id: 5,
    name: 'Family Minivan',
    image: 'https://via.placeholder.com/400x250?text=Family+Minivan',
    price: '30,000',
    description: 'Reliable and spacious minivan for all your family needs.',
    category: 'Minivans',
  },
  {
    id: 6,
    name: 'Compact City Car',
    image: 'https://via.placeholder.com/400x250?text=Compact+City+Car',
    price: '20,000',
    description: 'Perfect for navigating busy city streets and tight parking spots.',
    category: 'Hatchbacks',
  },
];

const ProductListPage = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [filterCategory, setFilterCategory] = useState('All');

  const filteredProducts = products.filter(product => {
    const matchesSearch = product.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
                          product.description.toLowerCase().includes(searchTerm.toLowerCase());
    const matchesCategory = filterCategory === 'All' || product.category === filterCategory;
    return matchesSearch && matchesCategory;
  });

  const uniqueCategories = ['All', ...new Set(products.map(product => product.category))];

  const cardVariants = {
    hidden: { opacity: 0, y: 50 },
    visible: { opacity: 1, y: 0, transition: { duration: 0.6, ease: 'easeOut' } },
    hover: { scale: 1.03, boxShadow: '0 8px 25px rgba(0,0,0,0.15)', transition: { duration: 0.2 } },
  };

  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />
      <Container className="my-5 flex-grow-1">
        <h1 className="text-center mb-4">Our Products</h1>

        <Row className="mb-4">
          <Col md={8}>
            <Form.Control
              type="text"
              placeholder="Search products..."
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
            />
          </Col>
          <Col md={4}>
            <Form.Select
              value={filterCategory}
              onChange={(e) => setFilterCategory(e.target.value)}
            >
              {uniqueCategories.map(category => (
                <option key={category} value={category}>{category}</option>
              ))}
            </Form.Select>
          </Col>
        </Row>

        <Row className="g-4">
          {filteredProducts.length > 0 ? (
            filteredProducts.map((product, index) => (
              <Col key={product.id} xs={12} sm={6} md={4} lg={3}>
                <motion.div
                  variants={cardVariants}
                  initial="hidden"
                  whileInView="visible"
                  viewport={{ once: true, amount: 0.3 }}
                  whileHover="hover"
                  transition={{ delay: index * 0.05 }}
                >
                  <Card className="h-100 shadow-sm">
                    <Card.Img variant="top" src={product.image} alt={product.name} style={{ height: '180px', objectFit: 'cover' }} loading="lazy" />
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
                        <Button variant="outline-secondary" size="sm">
                          Add to Cart
                        </Button>
                      </div>
                    </Card.Body>
                  </Card>
                </motion.div>
              </Col>
            ))
          ) : (
            <Col className="text-center">
              <p>No products found matching your criteria.</p>
            </Col>
          )}
        </Row>
      </Container>
      <Footer />
    </div>
  );
};

export default ProductListPage;
