import {DatePicker} from '@mui/x-date-pickers/DatePicker/DatePicker';
import Searchbar from '../../../components/SearchBar/SearchBar';
import ToTopLayout from '../../Layout/ToTopLayout';

const NewTrip = () => {
  return (
    <>
      <ToTopLayout>
        <div style={{display: 'flex', flexDirection: 'column', gap: '1rem'}}>
          <Searchbar placeholder="Startadresse"></Searchbar>
          <Searchbar placeholder="Zieladresse"></Searchbar>
          <DatePicker label="Datum" />
        </div>
      </ToTopLayout>
    </>
  );
};
export default NewTrip;
