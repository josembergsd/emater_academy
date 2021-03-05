import React, { Component } from 'react';
import { BrowserRouter } from 'react-router-dom';
import Routes from './routes';

import Header from './components/Header';
import Footer from './components/Footer';

class App extends Component{
  render() {
      return(
        <BrowserRouter>
            <Header />
            <Routes />
            <Footer />
        </BrowserRouter>
      );
  }
}

export default App;
