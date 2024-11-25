import TextField from '@mui/material/TextField';
import './LoginBox.scss';
import Button from '@mui/material/Button';

const LoginBox = () => {
    return (
        <div className="loginBox">
            <h2 style={{textAlign: 'start'}}>Login</h2>
            <div style={{display: 'flex', flexDirection: 'column'}}>
                <TextField
                    id="username"
                    label="username"
                    variant="outlined"
                    style={{marginBottom: '0.5rem'}}
                />
                <TextField
                    id="password"
                    label="password"
                    variant="outlined"
                    style={{marginBottom: '1vh'}}
                />
            </div>
            <div style={{display: 'flex', justifyContent: 'space-between'}}>
                <Button variant="contained">Sign in</Button>
                <Button variant="contained">Sign up</Button>
            </div>
        </div>
    );
};

export default LoginBox;
