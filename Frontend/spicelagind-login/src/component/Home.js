import React, { useState } from 'react';
import './Home.css';
import {useSpring,animated} from 'react-spring';
import Registration from './Registration';
import Login from './Login';



function Home() {
  const [registerationFormStatus, setRegistrationFormStatus]= useState(false);
  const loginProps=useSpring({
  left:registerationFormStatus ? -1000:0
 })

 const registerProps=useSpring({
  top:registerationFormStatus ? -300:5000
 })
  

  function registerClicked(){
    // alert('register clicked');
    setRegistrationFormStatus(true)
  }
  function loginClicked(){
    // alert('login clicked');
    setRegistrationFormStatus(false)
  }
  return (
    <div  className="login-register-wrapper">
      <div className='nav-buttons'>
      <button onClick={loginClicked} id="loginBtn" >Login  &nbsp;&nbsp;</button>
      <button onClick={registerClicked} id="registerBtn" >Register</button>
      </div>
      <div className='form-group'>
         <animated.form action='' id='loginform' style={loginProps}> 
          <Login /></animated.form> 
         <animated.form action='' id='registerform' style={registerProps}><Registration /></animated.form> 
      </div>
    
      <animated.div className='forgot-panel' style={loginProps}><a href='/forgotPass'>Forgot your password</a></animated.div>
    </div>
  );
}

export default Home;

