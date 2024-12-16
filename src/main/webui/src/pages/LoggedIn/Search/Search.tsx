import {DatePicker} from '@mui/x-date-pickers';
import Searchbar from '../../../components/SearchBar/SearchBar';
import ToTopLayout from '../../Layout/ToTopLayout';

const Search = () => {
  return (
    <ToTopLayout>
      <Searchbar placeholder="Zieladresse"></Searchbar>
      <DatePicker sx={{marginTop: '2rem'}} />
    </ToTopLayout>
  );
};

export default Search;
