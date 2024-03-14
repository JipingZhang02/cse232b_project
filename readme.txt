Environment:

The whole project is based on open source Amazon Corretto jdk11 and ANTLR4.13.1



How to use:
1. cd into current directory
2. make sure the specified xml file in xpath exists in current directory (e.g. j_caesar.xml file exists)
3. run command "java -jar [-mode <mode>] cse232b.jar [input_query_file_path] [output_xml_file_path]"
    <mode> can be "xpath", "xquery" or "ms3"
        if "-mode <mode>" does not exist in args, the mode will be milestone3 by default
    if input_query_file_path is not specified
        it is "./xpath.txt" by default in "xpath" mode,
              "./xquery.txt" by default in "xquery" and "ms3" mode
    if output_xml_file_path is not specified
        it is "./output.xml" by default

the behavior of reading input is like this:
    in evaluating xpath mode,
        ** only the first line **   of input file will be read as an absolute path
        other lines will be ignored
    in xquery and ms3 mode,
        ** lines before first blank line **   of input file will be read as a xquery
        other lines will be ignored
