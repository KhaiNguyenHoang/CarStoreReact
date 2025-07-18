import React from 'react';
import { Container, Row, Col, Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';

const categories = [
  {
    id: 1,
    name: 'Sedans',
    image: 'https://via.placeholder.com/300x200?text=Sedans',
  },
  {
    id: 2,
    name: 'SUVs',
    image: 'https://via.placeholder.com/300x200?text=SUVs',
  },
  {
    id: 3,
    name: 'Hatchbacks',
    image: 'https://via.placeholder.com/300x200?text=Hatchbacks',
  },
  {
    id: 4,
    name: 'Sports Cars',
    image: 'https://via.placeholder.com/300x200?text=Sports+Cars',
  },
];

const cardVariants = {
  hidden: { opacity: 0, y: 50 },
  visible: { opacity: 1, y: 0, transition: { duration: 0.6, ease: 'easeOut' } },
  hover: { scale: 1.03, boxShadow: '0 8px 25px rgba(0,0,0,0.15)', transition: { duration: 0.2 } },
};

const CategoriesSection = () => {
  return (
    <Container className="my-4 py-4">
      <h2 className="text-center mb-4">Shop by Category</h2>
      <Row className="g-4">
        {categories.map((category, index) => (
          <Col key={category.id} xs={12} sm={6} md={3}>
            <motion.div
              variants={cardVariants}
              initial="hidden"
              whileInView="visible"
              viewport={{ once: true, amount: 0.3 }}
              whileHover="hover"
              transition={{ delay: index * 0.1 }}
            >
              <Card className="h-100 shadow-sm">
                <Link to={`/categories/${category.id}`} className="text-decoration-none text-dark">
                  <Card.Img variant="top" src={category.image} alt={category.name} style={{ height: '180px', objectFit: 'cover' }} />
                  <Card.Body className="d-flex flex-column justify-content-center" style={{ minHeight: '60px' }}>
                    <Card.Title className="h5 text-center fw-bold mb-0">
                      {category.name}
                    </Card.Title>
                  </Card.Body>
                </Link>
              </Card>
            </motion.div>
          </Col>
        ))}
      </Row>
    </Container>
  );
};

export default CategoriesSection;
