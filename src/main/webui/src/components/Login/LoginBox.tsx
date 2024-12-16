import TextField from '@mui/material/TextField';
import './LoginBox.scss';
import Button from '@mui/material/Button';
import {NavLink} from 'react-router-dom';

const LoginBox = () => {
  // document.cookie = '';
  return (
    <div className="loginBox">
      <h2 style={{textAlign: 'start'}}>Login</h2>
      <div style={{display: 'flex', flexDirection: 'column', marginTop: '1rem'}}>
        <TextField id="username" label="username" defaultValue="admin" variant="outlined" style={{marginBottom: '0.5rem'}} />
        <TextField id="password" label="password" defaultValue="admin" variant="outlined" style={{marginBottom: '1vh'}} />
      </div>
      <div style={{display: 'flex', justifyContent: 'space-between'}}>
        <NavLink to={'/user/trips'}>
          <Button variant="contained">Sign in</Button>
        </NavLink>
        <Button variant="contained">Sign up</Button>
      </div>
    </div>
  );
};

export default LoginBox;
