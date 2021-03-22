import React, { Component } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import Routes from './routes';
import "./App.css";

import Header from './components/Header';
import Footer from './components/Footer';

class App extends Component{
  render() {
      return(
        <Router>
            <Header />
            <Routes />
            <Footer />
        </Router>
      );
  }
}

export default App;
