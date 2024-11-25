import {Link} from 'react-router-dom';

const Auth = () => {
  return (
    <div style={{height: '100vh', display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center'}}>
      <p>Auth</p>
      <Link to={'/user/trips'}>Fahrten</Link>
    </div>
  );
};

export default Auth;
