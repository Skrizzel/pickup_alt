import TextField from '@mui/material/TextField';
import './LoginBox.scss';
import Button from '@mui/material/Button';
import {Link} from 'react-router-dom';

const LoginBox = () => {
  return (
    <div className="loginBox">
      <h2 style={{textAlign: 'start'}}>Login</h2>
      <div style={{display: 'flex', flexDirection: 'column'}}>
        <TextField id="username" label="username" variant="outlined" style={{marginBottom: '0.5rem'}} />
        <TextField id="password" label="password" variant="outlined" style={{marginBottom: '1vh'}} />
      </div>
      <div style={{display: 'flex', justifyContent: 'space-between'}}>
        <Link to={'/user/trips'}>
          <Button variant="contained">Sign in</Button>
        </Link>
        <Button variant="contained">Sign up</Button>
      </div>
    </div>
  );
};

export default LoginBox;
