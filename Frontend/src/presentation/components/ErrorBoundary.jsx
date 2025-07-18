import React from 'react';
import { Container, Alert, Button } from 'react-bootstrap';

class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false, error: null, errorInfo: null };
  }

  static getDerivedStateFromError(error) {
    // Update state so the next render will show the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, errorInfo) {
    // You can also log the error to an error reporting service
    console.error("Uncaught error:", error, errorInfo);
    this.setState({
      error: error,
      errorInfo: errorInfo
    });
  }

  render() {
    if (this.state.hasError) {
      // You can render any custom fallback UI
      return (
        <div className="d-flex flex-column min-vh-100 justify-content-center align-items-center">
          <Container className="text-center">
            <Alert variant="danger">
              <Alert.Heading>Oops! Something went wrong.</Alert.Heading>
              <p>
                We're sorry, but there was an unexpected error.
              </p>
              <hr />
              <p className="mb-0">
                Please try refreshing the page or contact support if the issue persists.
              </p>
              {/* Optional: Display error details in development */}
              {process.env.NODE_ENV === 'development' && this.state.error && (
                <div className="mt-3 text-start">
                  <h6>Error Details:</h6>
                  <pre className="text-danger">
                    {this.state.error && this.state.error.toString()}
                    <br />
                    {this.state.errorInfo && this.state.errorInfo.componentStack}
                  </pre>
                </div>
              )}
              <Button variant="primary" onClick={() => window.location.reload()}>Refresh Page</Button>
            </Alert>
          </Container>
        </div>
      );
    }

    return this.props.children;
  }
}

export default ErrorBoundary;
