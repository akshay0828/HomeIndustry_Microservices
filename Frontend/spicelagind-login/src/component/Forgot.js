import React from "react";
import { Form } from "react-bootstrap";
import axios from "axios";

class Forgot extends React.Component{

    constructor(props){
        super(props);
        this.state= this.initiaLSTATE;
        this.state={};
    }
    
    initiaLSTATE={
        username:""
    };
    handlesubmit=(event)=>{
    
        const user={
            username:this.state.username
          }
          axios.post("http://localhost:9001/api/loginservice/forgotpassword",user).then(response => {
            if(response.data==="forgotpassword"){
                this.setState(this.initiaLSTATE);
                alert("User doesnot Exists"); 

            }
            else{
                alert("change password")
            }
          } )
        }
        onInputChange=(e)=>{
            this.setState({
                [e.target.name]: e.target.value,
            })
          }
          render(){
            return(
                <React.Fragment>
              <Form >
              <label for="username">Username</label>
               <input type="text" required pattern="[A-Za-z]{3,10}" title="User name must be between 3-10 characters!!" id="fullname" name="username" value={this.state.username} placeholder="Enter Username" onChange={this.onInputChange}/>
               <input type="submit"  onClick={this.handlesubmit} className='submit' value="change password" ></input> 
                </Form>
                </React.Fragment>
            )
          }
        
}
export default Forgot;
