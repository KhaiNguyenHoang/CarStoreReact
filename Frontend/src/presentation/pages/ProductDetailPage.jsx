import React from 'react';
import { useParams } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { addToCart } from '../../application/cart/cartSlice';
import { Container, Row, Col, Card, Button, Carousel } from 'react-bootstrap';
import Header from '../components/Header';
import Footer from '../components/Footer';

const products = [
  {
    id: 1,
    name: 'Luxury Sedan',
    images: [
      'https://via.placeholder.com/800x600?text=Luxury+Sedan+1',
      'https://via.placeholder.com/800x600?text=Luxury+Sedan+2',
      'https://via.placeholder.com/800x600?text=Luxury+Sedan+3',
    ],
    price: '50,000',
    description: 'A sleek and powerful luxury sedan with advanced features. Experience unparalleled comfort and cutting-edge technology. Perfect for both city driving and long-distance journeys.',
    category: 'Sedans',
    specs: {
      engine: '2.0L Turbo',
      horsepower: '250 HP',
      transmission: 'Automatic',
      fuelType: 'Gasoline',
      color: 'Black',
    },
    reviews: [
      { id: 1, author: 'John Doe', rating: 5, comment: 'Amazing car, very comfortable and stylish!' },
      { id: 2, author: 'Jane Smith', rating: 4, comment: 'Great performance, a bit pricey but worth it.' },
    ],
  },
  {
    id: 2,
    name: 'Sport SUV',
    images: [
      'https://via.placeholder.com/800x600?text=Sport+SUV+1',
      'https://via.placeholder.com/800x600?text=Sport+SUV+2',
      'https://via.placeholder.com/800x600?text=Sport+SUV+3',
    ],
    price: '45,000',
    description: 'Spacious and versatile sport utility vehicle, perfect for families and adventurers. Enjoy a smooth ride and ample cargo space.',
    category: 'SUVs',
    specs: {
      engine: '2.5L V6',
      horsepower: '280 HP',
      transmission: 'Automatic',
      fuelType: 'Gasoline',
      color: 'White',
    },
    reviews: [
      { id: 3, author: 'Peter Jones', rating: 5, comment: 'Perfect family car, very safe and reliable.' },
      { id: 4, author: 'Mary Brown', rating: 4, comment: 'Love the design and the space it offers.' },
    ],
  },
  {
    id: 3,
    name: 'Electric Hatchback',
    images: [
      'https://via.placeholder.com/800x600?text=Electric+Hatchback+1',
      'https://via.placeholder.com/800x600?text=Electric+Hatchback+2',
      'https://via.placeholder.com/800x600?text=Electric+Hatchback+3',
    ],
    price: '35,000',
    description: 'Eco-friendly and efficient electric car for urban adventures. Zero emissions and low running costs make it an ideal choice.',
    category: 'Hatchbacks',
    specs: {
      engine: 'Electric Motor',
      horsepower: '150 HP',
      transmission: 'Automatic',
      fuelType: 'Electric',
      color: 'Blue',
    },
    reviews: [
      { id: 5, author: 'David Green', rating: 5, comment: 'Fantastic electric car, very quiet and smooth.' },
      { id: 6, author: 'Sarah Lee', rating: 3, comment: 'Good for city, but range could be better.' },
    ],
  },
  {
    id: 4,
    name: 'Classic Roadster',
    images: [
      'https://via.placeholder.com/800x600?text=Classic+Roadster+1',
      'https://via.placeholder.com/800x600?text=Classic+Roadster+2',
      'https://via.placeholder.com/800x600?text=Classic+Roadster+3',
    ],
    price: '70,000',
    description: 'Timeless design meets modern performance in this classic roadster. A true collector's item with exhilarating driving dynamics.',
    category: 'Sports Cars',
    specs: {
      engine: '3.0L V6',
      horsepower: '300 HP',
      transmission: 'Manual',
      fuelType: 'Gasoline',
      color: 'Red',
    },
    reviews: [
      { id: 7, author: 'Chris Evans', rating: 5, comment: 'Absolutely stunning car, a joy to drive!' },
      { id: 8, author: 'Emily White', rating: 5, comment: 'Turns heads everywhere, classic beauty.' },
    ],
  },
  {
    id: 5,
    name: 'Family Minivan',
    images: [
      'https://via.placeholder.com/800x600?text=Family+Minivan+1',
      'https://via.placeholder.com/800x600?text=Family+Minivan+2',
      'https://via.placeholder.com/800x600?text=Family+Minivan+3',
    ],
    price: '30,000',
    description: 'Reliable and spacious minivan for all your family needs. Comfortable seating and ample storage make every trip a breeze.',
    category: 'Minivans',
    specs: {
      engine: '3.5L V6',
      horsepower: '270 HP',
      transmission: 'Automatic',
      fuelType: 'Gasoline',
      color: 'Silver',
    },
    reviews: [
      { id: 9, author: 'Michael Green', rating: 4, comment: 'Great for large families, very practical.' },
      { id: 10, author: 'Olivia Black', rating: 5, comment: 'So much space, kids love it!' },
    ],
  },
  {
    id: 6,
    name: 'Compact City Car',
    images: [
      'https://via.placeholder.com/800x600?text=Compact+City+Car+1',
      'https://via.placeholder.com/800x600?text=Compact+City+Car+2',
      'https://via.placeholder.com/800x600?text=Compact+City+Car+3',
    ],
    price: '20,000',
    description: 'Perfect for navigating busy city streets and tight parking spots. Economical and easy to maneuver.',
    category: 'Hatchbacks',
    specs: {
      engine: '1.0L 3-Cylinder',
      horsepower: '90 HP',
      transmission: 'Manual',
      fuelType: 'Gasoline',
      color: 'Yellow',
    },
    reviews: [
      { id: 11, author: 'Sophia White', rating: 4, comment: 'Ideal for city driving, very fuel efficient.' },
      { id: 12, author: 'Daniel King', rating: 3, comment: 'A bit small for long trips, but great for daily commute.' },
    ],
  },
];

const ProductDetailPage = () => {
  const { id } = useParams();
  const product = products.find(p => p.id === parseInt(id));

  if (!product) {
    return (
      <div className="d-flex flex-column min-vh-100">
        <Header />
        <Container className="my-5 flex-grow-1 text-center">
          <h2>Product Not Found</h2>
          <p>The product you are looking for does not exist.</p>
          <Button variant="primary" as={Link} to="/products">Back to Products</Button>
        </Container>
        <Footer />
      </div>
    );
  }

  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />
      <Container className="my-5 flex-grow-1">
        <Row>
          <Col md={6}>
            <Carousel>
              {product.images.map((image, index) => (
                <Carousel.Item key={index}>
                  <img
                    className="d-block w-100"
                    src={image}
                    alt={`${product.name} ${index + 1}`}
                    style={{ maxHeight: '450px', objectFit: 'contain' }}
                    loading="lazy"
                  />
                </Carousel.Item>
              ))}
            </Carousel>
          </Col>
          <Col md={6}>
            <h1>{product.name}</h1>
            <p className="lead text-primary fw-bold">${product.price}</p>
            <p>{product.description}</p>
            <Button variant="primary" size="lg" className="mt-3" onClick={handleAddToCart}>
              Add to Cart
            </Button>

            <h3 className="mt-5">Specifications</h3>
            <ul className="list-unstyled">
              {Object.entries(product.specs).map(([key, value]) => (
                <li key={key}><strong>{key.charAt(0).toUpperCase() + key.slice(1)}:</strong> {value}</li>
              ))}
            </ul>

            <h3 className="mt-5">Customer Reviews</h3>
            {product.reviews.length > 0 ? (
              <div>
                {product.reviews.map(review => (
                  <Card key={review.id} className="mb-3">
                    <Card.Body>
                      <Card.Title>{review.author} - Rating: {review.rating}/5</Card.Title>
                      <Card.Text>{review.comment}</Card.Text>
                    </Card.Body>
                  </Card>
                ))}
              </div>
            ) : (
              <p>No reviews yet. Be the first to review this product!</p>
            )}
          </Col>
        </Row>
      </Container>
      <Footer />
    </div>
  );
};

export default ProductDetailPage;
