import Searchbar from '../../../components/SearchBar/SearchBar';
import ToTopLayout from '../../Layout/ToTopLayout';

const NewTrip = () => {
  return (
    <>
      <ToTopLayout>
        <Searchbar placeholder="Startadresse"></Searchbar>
        <Searchbar placeholder="Zieladresse"></Searchbar>
      </ToTopLayout>
    </>
  );
};
export default NewTrip;
