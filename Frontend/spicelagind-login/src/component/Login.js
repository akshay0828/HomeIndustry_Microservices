import React from "react";
import { Form } from "react-bootstrap";
import axios from "axios";

class Login extends React.Component{
    constructor(props){
        super(props);
        this.state= this.initiaLSTATE;
        this.state={
            user:[]
        };
    }
    initiaLSTATE={
        username:"",
        pass:""
    };
    handlesubmit= (event) => {
        alert(this.state.username)
        const user={
            username:this.state.username,
            pass:this.state.pass
        }
        console.log("hii");
        axios.post('http://localhost:9001/api/loginservice/login',user).then(Response=>{
  
        if(Response.data==="sucess"){
                alert("log in success")
                
            }
            else{
                alert("login failed")
            }
        })  
    }
    onInputChange=(e)=>{
        this.setState({
            [e.target.name]: e.target.value,
        })
      
    }
      render(){
        return (
            <React.Fragment>
             <Form>
            <label for='username'>Username</label>
            <input type="text" placeholder="Enter Username"  id="username"  name="username" value={this.state.username} required pattern="[A-Za-z]{3,10}"  title="User name must be between 3-10 characters!!"  onChange={this.onInputChange}/>
        
            <label for='pass'>Password</label>
            <input type="password" placeholder="Enter Password"  id="exampleInputPassword1" name="pass" value={this.state.pass} required pattern="[A-Za-z0-9#@$&]{3,10}" title="Password must be between 3-10 characters and type only valid characters!!" onChange={this.onInputChange}/>
          {/* <center> ${error }</center> */}
        
            <center><input type="submit" onClick={this.handlesubmit} value="Sign In" className='submit'/></center>
            </Form>
            </React.Fragment>
          )
        }
}

export default Login;
