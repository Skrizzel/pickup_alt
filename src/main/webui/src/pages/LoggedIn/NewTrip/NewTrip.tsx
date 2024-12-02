import {DatePicker} from '@mui/x-date-pickers/DatePicker/DatePicker';
import Searchbar from '../../../components/SearchBar/SearchBar';
import ToTopLayout from '../../Layout/ToTopLayout';
import {
  Checkbox,
  Box,
  Paper,
  Switch,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  SelectChangeEvent,
  FormControlLabel,
  FormLabel,
  Radio,
  RadioGroup,
} from '@mui/material';
import {ClockIcon} from '@mui/x-date-pickers';
import {useState} from 'react';

// const label = {inputProps: {'aria-label': 'Checkbox demo'}};

const NewTrip = () => {
  const [car, setCar] = useState('');

  const handleChange = (event: SelectChangeEvent) => {
    setCar(event.target.value as string);
  };

  return (
    <>
      <ToTopLayout>
        <div style={{display: 'flex', flexDirection: 'column', gap: '1rem'}}>
          <Searchbar placeholder="Startadresse"></Searchbar>
          <Searchbar placeholder="Zieladresse"></Searchbar>
          <DatePicker label="Datum" />
          <Paper sx={{padding: '1rem'}}>
            <Box sx={{display: 'flex', flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center'}}>
              <Box sx={{display: 'flex', flexDirection: 'row', gap: '0.5rem'}}>
                <ClockIcon /> <h3>Wiederholdende Fahrt</h3>
              </Box>
              <Switch />
            </Box>
            {['Täglich', 'Wöchentlich', 'Montlich'].map((element) => (
              <Box sx={{display: 'flex', justifyContent: 'space-between'}}>
                {element}
                <Checkbox />
              </Box>
            ))}
            <DatePicker sx={{display: 'flex', justifySelf: 'center', width: '100%'}} label="End Datum" />
          </Paper>

          <FormControl fullWidth>
            <InputLabel id="car-select-label">Fahrzeug</InputLabel>
            <Select labelId="demo-simple-select-label" id="demo-simple-select" value={car} label="Age" onChange={handleChange}>
              {['Audi'].map((car) => (
                <MenuItem value={car}>{car}</MenuItem>
              ))}
            </Select>
          </FormControl>
          <FormControl>
            <FormLabel id="demo-radio-buttons-group-label">Sitzplätze: </FormLabel>
            <RadioGroup
              sx={{display: 'flex', flexDirection: 'row'}}
              aria-labelledby="demo-radio-buttons-group-label"
              defaultValue="female"
              name="radio-buttons-group"
            >
              <FormControlLabel value="1" control={<Radio />} label="1" />
              <FormControlLabel value="2" control={<Radio />} label="2" />
              <FormControlLabel value="3" control={<Radio />} label="3" />
              <FormControlLabel value="4" control={<Radio />} label="4" />
              <FormControlLabel value="5" control={<Radio />} label="5" />
              <FormControlLabel value="6" control={<Radio />} label="6" />
            </RadioGroup>
          </FormControl>
        </div>
      </ToTopLayout>
    </>
  );
};
export default NewTrip;
