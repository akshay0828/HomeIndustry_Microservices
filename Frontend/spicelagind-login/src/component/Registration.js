import React from "react";
import { Form } from "react-bootstrap";
import axios from "axios";

class Registration extends React.Component{

    constructor(props){
        super(props);
        // this.state= this.initiaLSTATE;
        this.state={
          // roles:[],
        };
        
    }

  //   login(){
  //     return this.props.history.push("/");
  // }


    // initiaLSTATE={
    //     id:"",
    //     name:"",
    //     username:"",
    //     email:"",
    //     contact:"",
    //     pass:"",
    //     cnfmpass:"",
    //     address:"",
    //     area:"",
    //     role:"",
    // };
    // componentDidMount() {
    //   let initialroles = [];
    //   fetch('http://localhost:9001/api/loginservice/role')
    //     .then(response => {
    //         return response.json();
    //       }).then(data => {
    //       initialroles = data.results && data.results.map((role) => {
    //           return role
    //     //  console.log(role)
    // });
    // then(Response => Response.data).then((data)=>{this.setState({hospitals:data})});
  //         console.log(initialroles);
  //         this.setState({
  //           role:data,
  //         });
  //     });
  // }
    handlesubmit=(event)=>{
      // event.preventDefault()

        const user={
            name:this.state.name,
            username:this.state.username,
            email:this.state.email,
            contact:this.state.contact,
            pass:this.state.pass,
            address:this.state.address,
            area:this.state.area,
            role:this.state.role,
           
          }
          const confirmpassword= this.state.cnfmpass;
          const password = this.state.pass; 
          if(confirmpassword===password) {
            // alert("hi")
            axios.post("http://localhost:9001/api/loginservice/register",user).then(response => {
                if(response.data==="Username Already Exists"){
                    this.setState(this.initiaLSTATE);
                    alert("Username Already Exists"); 
                    window.location.reload();
                }
                else{
                    alert("user saved")
                }
              } )

            // axios.post("http://localhost:9001/api/loginservice/register",user).then(response=>alert(response.data))
            // alert("hii")
         }
         else{
            alert("password and confirm password mismatch");
         }
    }

     onInputChange=(e)=>{
        this.setState({
            [e.target.name]: e.target.value,
        })
      }
    render(){
      // let role=this.state.role;
      // let optionItems = role && role.map((role) =>
      //           <option key={role.name} value={role.name}>{role.name}</option>
      //       );

        return(
            <React.Fragment>
          <Form >
             <label for="name">name</label>
               <input type="text"  pattern="[A-Za-z]{3,10}" title="User name must be between 3-10 characters!!" id="name" name="name" value={this.state.name} placeholder="Enter Name" onChange={this.onInputChange} required/>
              <label for="username">Username</label>
               <input type="text" required pattern="[A-Za-z]{3,10}" title="User name must be between 3-10 characters!!" id="fullname" name="username" value={this.state.username} placeholder="Enter Username" onChange={this.onInputChange}/>
              <label for="email">Email</label> 
               <input type="email" id="email"	required name="email" value={this.state.email} placeholder="Enter Email" onChange={this.onInputChange} />
              <label for="phoneNumber">Phone Number</label> 
               <input type="text" required id="phoneNumber" name="contact" value={this.state.contact} pattern="^\d{10}$" title="Invalid Phone number!!" placeholder="Enter Phone Number" onChange={this.onInputChange}/> 
              <label for="password">Password</label> 
                <input type="password" required id="password" name="pass" value={this.state.pass} placeholder="Enter Password" pattern="[A-Za-z0-9#@$&]{3,10}" title="Password must be between 3-10 characters and type only valid characters!!" onChange={this.onInputChange}/>
              <label for="confirmPassword">Confirm Password</label>
               <input type="password" id="confirmPassword" name="cnfmpass"  value={this.state.cnfmpass}required placeholder="Confirm Password" onChange={this.onInputChange}/>
               <label for="address">Address</label> <input type="text"	id="address" name="address" value={this.state.address} required placeholder="address" onChange={this.onInputChange}/>
               <label for="area">Area</label> <input type="text"
                                    id="area" name="area" value={this.state.area} required placeholder="Area" onChange={this.onInputChange}/>
               <label for="role">Select Your Role</label><br></br>
             <select id="vehicleList" name="role" required onChange={this.onInputChange}>
                                  
                      <option value="" disabled selected>Select Your Role</option> 
                       {/* <option value="ADMIN" >ADMIN</option>  */}
                      <option value="VENDOR">VENDOR</option>
                      <option value="USER">USER</option>
                      <option value="DELIVERY">DELIVERY</option>
                        {/* <c:forEach var="v" items="${roleval}"> */}
                          {/* <option id="aa" ></option> */}
                        {/* </c:forEach>	 */}
                        {/* {optionItems} */}

               </select>
               
                <input type="submit"  onClick={this.handlesubmit} className='submit' value="Submit and Back to Login" ></input> 
               {/* <input type="submit" className='submit' value="cancel"></input> */}
               </Form>
               </React.Fragment>
             
          )
    }
}

export default Registration;
