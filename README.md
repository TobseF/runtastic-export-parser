# Runtastic Export Parser

Thanks to the DSGV [runtastic](https://www.runtastic.com/) added a export functionality for complete manual backups.
This is a small Kotlin based script that reads the json files in the export and formats it as CSV. So it can be easily imported in a Excel or Google spreadsheet.

## Download export from runtastic
1. Click on account icon
2. Open settings
3. Navigate to Export
4. Trigger and download new export

## Format weights
For now this scripts supports only the `Weight` folder.
Run `Parser.kt` with the `Weight` directory as argument.
It will print the formatted file in the console.
The output is formatted with a German locale.

## Example
**JSON input file:**
``` json
{
  "start_time": 1461193342000,
  "created_at": 1501714959000,
  "updated_at": 1501714959000,
  "start_time_timezone_offset": 7200000,
  "weight": 42.0,
  "origin_type": "manual",
  "id": "525a0fecbcoff335b2b72d1b"
}
```
Will be converted to:
```
21.04.2016;42,0
```