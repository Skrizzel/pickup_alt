import {useState} from 'react';
import Avatar from '@mui/material/Avatar';
import ToTopLayout from '../../Layout/ToTopLayout';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import AddIcon from '@mui/icons-material/Add';
import EditIcon from '@mui/icons-material/Edit';
import CheckIcon from '@mui/icons-material/Check';
// import Container from '@mui/material/Container';
import {listItemStyle, styleForListItemContainer} from '../../../shared/styles';
import TextField from '@mui/material/TextField';
import {Box, IconButton} from '@mui/material';
import {NavLink} from 'react-router-dom';

const Profile = () => {
  const tesSettings = {
    Nutzername: 'Max Mustermann',
    'E-mail': 'Max.Mustermann@bube.com',
    Telefonnummer: '012345678910',
    Passwort: '********',
    Fahrzeug: 'Subaru Legacy',
  };

  const sizeOfAvatar = '100px';

  // State to track the editable status for each field
  const [editStatus, setEditStatus] = useState(
    Object.keys(tesSettings).reduce((acc: Record<string, boolean>, key) => {
      acc[key] = true; // Initially, all fields are disabled
      return acc;
    }, {})
  );

  const onEdit = (key: string) => {
    setEditStatus((prevStatus) => ({
      ...prevStatus,
      [key]: !prevStatus[key], // Toggle the edit state for the specific field
    }));
  };

  return (
    <ToTopLayout>
      <Box sx={{width: '100%', display: 'flex', justifyContent: 'center'}}>
        <Avatar sx={{height: sizeOfAvatar, width: sizeOfAvatar}}>Me</Avatar>
      </Box>
      <List sx={{paddingTop: '0px', marginTop: '1rem'}}>
        {Object.entries(tesSettings).map(([key, val], index) => (
          <Box sx={styleForListItemContainer} key={index}>
            <ListItem
              sx={{
                ...listItemStyle,
                '*, *::before, *::after': {
                  transition: 'none !important',
                  animation: 'none !important',
                },
              }}
            >
              <TextField
                disabled={editStatus[key]} // Control the disabled state per field
                id={`field-${key}`}
                defaultValue={val}
                label={key}
                variant="standard"
              />
            </ListItem>
            <IconButton onClick={() => onEdit(key)} aria-label={`edit-${key}`} sx={{padding: 0}}>
              {editStatus[key] ? <EditIcon /> : <CheckIcon />}
            </IconButton>
          </Box>
        ))}
        <Box sx={styleForListItemContainer} key={Object.keys(tesSettings).length}>
          <ListItem sx={listItemStyle}>
            <p>Fahrzeug erstellen</p>
          </ListItem>
          <NavLink to={'/user/car'} style={{display: 'flex'}}>
            <AddIcon sx={{display: 'flex', alignSelf: 'center'}} />
          </NavLink>
        </Box>
      </List>
    </ToTopLayout>
  );
};

export default Profile;
