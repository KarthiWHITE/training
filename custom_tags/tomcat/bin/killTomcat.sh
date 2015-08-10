running=$(ps auxwww | grep "control-server.*startup.Bootstrap" | grep -v "grep")
tompid=$(ps auxwww | grep "control-server.*startup.Bootstrap" | grep -v "grep" | awk '{ print $2 }' )
if [ -n "$tompid" ]
then
echo " Tomcat (Java) still running in $tompid . Killing"
echo " $running "
#read dummyvar
kill -9 $tompid
else
echo "Tomcat is not running"
fi

type fswatch >/dev/null 2>&1
if [ $? -eq 0 ]
then
    echo " fswatch is present" 
 fswatch_pid=$(ps -A | grep "fswatch.*WEB-INF" | grep -v "grep" | awk '{print $1}')
 echo "fswatch pid is $fswatch_pid"
 #read dummy
 if [ -n "$fswatch_pid" ] 
 then
    echo "Killing fswatch $fswatch_pid"
    kill -9  $fswatch_pid
 fi 
fi

rm -f .class_modified
