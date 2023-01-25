import React from 'react';
import './App.css';
import './Admin.css'
import './Customer.css'

import Forgot from './component/Forgot';
import Home from './component/Home';
import Password from './component/Password';
import AdminHomePage from './component/AdminHomePage';
import Dashboard from './component/DeliveryDashboard';
import Customer from './component/Customer';
import VendorHomePage from './component/VendorHomePage';
import AddProducts from './component/AddProducts';
import ManageProducts from './component/ManageProducts';
import UpdateProduct from './component/UpdateProducts';
import UpdateProfile from './component/UpdateProfile';
import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
import {Container, Row, Col} from 'react-bootstrap';



function App() {

  const marginTop={

    marginTop:"20px"

  };

  return (

   

      <Router>

      

      <Container>

        <Row>

         <Col lg={12} style={marginTop}>

      <Routes>

        <Route exact path ="/" element={<Home/>}></Route>
        <Route exact path ="/forgotPass" element={<Forgot/>}></Route>
        <Route exact path ="/changePass/:username" element={<Password />}></Route>
        <Route exact path ="/admin/:id" element={<AdminHomePage />}></Route>
        <Route exact path ="/delivery/:id" element={<Dashboard />}></Route>
        <Route exact path ="/user/:id" element={<Customer />}></Route>
        <Route exact path="/vendor/:id" element={<VendorHomePage />}/> 
         <Route exact path="/addProducts/:id" element={< AddProducts />}/> 
        <Route exact path="/manageProducts/:id" element={< ManageProducts />}/> 
         <Route exact path="/updateProfile/:id" element={< UpdateProfile />}/> 
        <Route exact path="/updateProduct/:id" element={< UpdateProduct />}/>
      </Routes>

       </Col>

        </Row>

      </Container>

      </Router>

   



  );

}



export default App;

