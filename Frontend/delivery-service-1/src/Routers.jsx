import { Route } from 'react-router-dom';

function DeliveryRouter() {
  return (
    <Router>
      <div>
        <Route path="/users/:id" component={UserProfile} />
        <Route path="/about" component={About} />
      </div>
    </Router>
  );
}
export default DeliveryRouter;