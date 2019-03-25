Base256 encoding

This uses the UTF-8 charset to encode a file/text into base256 so that it can be transmitted in a texual format embedded in XML and JSON documents.

Usage:

Add this as a maven or gradle dependency

https://search.maven.org/artifact/com.github.bharatmicrosystems/base256/0.0.2/jar


Sample Test is included in the code:

Encode : 
String encodedString = Base256.base256Encode(FileUtils.readFileToByteArray(new File("src/test/resources/img.jpg")));

Decode:
byte[] decodedString = Base256.base256Decode(encodedString);


Charset used : àáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽžſƀƁƂƃƄƅƆƇƈƉ=_-`~|[]{}ƞ?,()^*$%!#.ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/

