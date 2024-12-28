import BottomNavigation from '@mui/material/BottomNavigation/BottomNavigation';
import CarIcon from './CarIcon';
import './Footer.scss';
import PersonIcon from './PersonIcon';
import BottomNavigationAction from '@mui/material/BottomNavigationAction/BottomNavigationAction';
import {useState} from 'react';
import {useNavigate} from 'react-router-dom';
import ChatIcon from './ChatIcon';
// import {Paper} from '@mui/material';

const Footer = () => {
  const [value, setValue] = useState(window.location.href.split('/').pop());
  const navigate = useNavigate();

  return (
    <>
      <div
        id="footer"
        style={{
          // height: '100%',
          // display: 'flex',
          // flexDirection: 'column',
          // justifyContent: 'flex-end',
          position: 'fixed',
          bottom: '0',
          width: '100%',
          overflowX: 'auto',
        }}
      >
        <BottomNavigation
          showLabels
          value={value}
          sx={{justifyContent: 'space-around'}}
          onChange={(_event, newValue) => {
            setValue(newValue);
            navigate(newValue);
          }}
        >
          <BottomNavigationAction value="trips" label="Fahrten" icon={<CarIcon />} />
          {/* <BottomNavigationAction label="Chat" value="chat" icon={<ChatIcon />} /> */}
          <BottomNavigationAction label="Konto" value="profile" icon={<PersonIcon />} />
        </BottomNavigation>
      </div>
    </>
  );
};

export default Footer;
