import React from "react";
import { Form } from "react-bootstrap";
  import axios from "axios";
  import { useParams } from "react-router";

  function withParams(Component) {
    return props => <Component {...props} params={useParams()} />;
   }

   class Payment extends React.Component{
   
    constructor(props){
        super(props);
        this.state={
        };


    } 

    
    
    handlepayment(){
       
        // event.preventDefault()
        const payment={
          tranzactinId:this.state.tranzactinId,
          paymentMethod:this.state.paymentMethod,
          paymentType:this.state.paymentType,
          totalAmount:this.state.totalAmount,
          cardNo:this.state.cardNo,
        }
        alert("hiii")
        let {id} = this.props.params;
            
        axios.post("http://localhost:9003/api/customer/paymentSucces/"+id,payment).then(response => {
          if(response.data==="orderPlaced and payement successful"){
                // this.setState(this.state.payment)
              alert("orderPlaced and payement successful"); 
              window.location="/customer/"+id;
          }
          else{
              alert("payment unsuccessfull")
          }
        });
      
      }
      onInputChange=(e)=>{
        this.setState({
            [e.target.name]: e.target.value,
        })
      }
      render(){

        return(
            <Form >
                <center><h1>Payment </h1>
          <label for="tranzactinId">TranzactionId:</label> &nbsp;&nbsp;
              <input type="text"   id="tranzactinId" name="tranzactinId" value={this.state.tranzactinId} placeholder="Enter Transaction id" onChange={this.onInputChange} required/><br></br><br></br><br></br>
             <label for="paymentMethod">paymentMethod:</label> &nbsp;&nbsp;
              <input type="text" required  name="paymentMethod" value={this.state.paymentMethod} placeholder="Enter paymentMethod" onChange={this.onInputChange}/><br></br><br></br><br></br>
             <label for="paymentType">paymentType:</label>  &nbsp;&nbsp;
              <input type="paymentType" id="paymentType"	required name="paymentType" value={this.state.paymentType} placeholder="Enter paymentType" onChange={this.onInputChange} /><br></br><br></br><br></br>
             <label for="totalAmount">TotalAmount:</label>  &nbsp;&nbsp;
              <input type="text" required id="totalAmount" name="totalAmount" value={this.state.totalAmount}  placeholder="Enter totalAmount" onChange={this.onInputChange}/> <br></br><br></br><br></br>
             <label for="cardNo">cardNo:</label>  &nbsp;&nbsp;
               <input type="cardNo" required id="cardNo" name="cardNo" value={this.state.cardNo} placeholder="Enter cardNo"   onChange={this.onInputChange}/><br></br><br></br><br></br>
               <input type="submit"  onClick={()=>this.handlepayment()} className='submit' value="payment" ></input> 
               </center>
             </Form>
               )

            }
}
export default withParams(Payment);