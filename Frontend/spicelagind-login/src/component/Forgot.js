import React from "react";

import axios from "axios";

import { useNavigate } from "react-router-dom";
import './Home.css';



class Forgot extends React.Component{

    constructor(props){
        super(props);
        this.state= this.initiaLSTATE;
        this.state={};
    }
    
    initiaLSTATE={
        username:""
    };
     handlesubmit = (event)=>{
       
        event.preventDefault()

        const user={
            username:this.state.username
          }
          axios.post("http://localhost:9001/api/loginservice/forgotpassword",user).then(response => {
            if(response.data==="forgotpassword"){
                this.setState(this.initiaLSTATE);
                alert("User doesnot Exists"); 

            }
            else{
               window.location="/changepass/"+user.username;
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
                <div className="forgot">
                <React.Fragment>
              <form onSubmit={this.handlesubmit}>
              <label for="username">Username</label>&nbsp;
               <input type="text" required pattern="[A-Za-z]{3,10}" title="User name must be between 3-10 characters!!" id="fullname" name="username" value={this.state.username} placeholder="Enter Username" onChange={this.onInputChange}/>
                <br></br>
              {/* <Link to={"/changepass"}>  */}
             {/* <button  type="submit">change password</button>  */}
              <input type="submit"  onClick={this.handlesubmit} className='forgotsubmit' value="change password" ></input>
             {/* </Link>  */}
                </form>
                </React.Fragment>
                </div>
            )
          }
        
}
export default Forgot;
