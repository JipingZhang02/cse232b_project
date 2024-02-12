To use the code:

1. cd into current directory
2. make sure the specified xml file in xpath exists in current directory (e.g. j_caesar.xml file exists)
3. run command "java -jar cse232b.jar <input_xpath_file_path> [output_xml_file_path]"
    replace <input_xpath_file_path> with path to input xpath file's path
        the first line of xpath file will be interpreted as xpath and then be evaluated
        the rest lines will be ignored.
    replace [output_xml_file_path] with expected output file path
        this argument is optional
        if you don't pass in this argument, the output path will be ./output.xml by default.

Note:
    Since the evaluate result main contain multiple elements
    In order to make evaluate result a valid xml file,
        the evaluate result will be wrapped in a <SearchResult> </SearchResult> tag.