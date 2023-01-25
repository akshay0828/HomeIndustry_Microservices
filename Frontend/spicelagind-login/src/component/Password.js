import React from "react";
import { Form } from "react-bootstrap";
import axios from "axios";
import { useParams } from "react-router";

function withParams(Component) {
     return props => <Component {...props} params={useParams()} />;
    }
class Password extends React.Component{
    
    constructor(props){
                super(props);
           
                this.state= this.initiaLSTATE;
                this.state={ 
                    user:[]
                };
               
            }
           
            initiaLSTATE={
                        username: this.props.params,
                        pass:"",
                        cnfmpass:""
                        
                    };
        
                    handlesubmit= (event) => {
                        event.preventDefault()
                        let {username}= this.props.params;
                                const user={
                                    username:username,
                                    pass:this.state.pass,
                                    cnfmpass:this.state.cnfmpass
                                }
                          
                                
                                console.log("hii");
                                const confirmpassword= this.state.cnfmpass;
                                const password = this.state.pass; 
                                if(confirmpassword===password) {
                                axios.post('http://localhost:9001/api/loginservice/changepassword',user).then(Response=>{
                          
                                if(Response.data==="password changed"){
                                        alert("password changed")
                                        window.location="/"
                                        
                                    }
                                })  
                            }  else{
                                alert("password is not matching")
                                window.location.reload();
                            }
                         }
                            onInputChange=(e)=>{
                                this.setState({
                                    [e.target.name]: e.target.value,
                                })
                    }
    render(){
      
        return (
            
            <React.Fragment>
                
      
              <div  className="forgot-password">
              <div className='form-group'>
          <Form >
            <br></br>
       {/* <label for='username'>Username</label>
         <input type="text" placeholder="Enter Username"  id="username"  name="username" value={this.state.username} required pattern="[A-Za-z]{3,10}"  title="User name must be between 3-10 characters!!"  onChange={this.onInputChange}/><br></br> */}
        
  <label for='pass'>Password</label>
         <input type="password" placeholder="Enter Password"  id="exampleInputPassword1" name="pass" value={this.state.pass} required pattern="[A-Za-z0-9#@$&]{3,10}" title="Password must be between 3-10 characters and type only valid characters!!" onChange={this.onInputChange}/><br></br>
       {/* <center> ${error }</center> */}
        <label for="confirmPassword">Confirm Password</label>
         <input type="password" id="confirmPassword" name="cnfmpass"  value={this.state.cnfmpass} required placeholder="Confirm Password" onChange={this.onInputChange}/><br></br>
              
  <center><input type="submit" onClick={this.handlesubmit} value="Sign In" className='forgotsubmit'/></center>
    </Form>
    </div>
    </div>
      </React.Fragment>

    );
}

}
export default withParams(Password);
