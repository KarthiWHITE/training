sh killTomcat.sh
rm -rf ../logs/*.*
#export JPDA_SUSPEND="y"
if [ -d ../../jnotify ]; then
export LD_LIBRARY_PATH=$(pwd)/../../jnotify
export DYLD_LIBRARY_PATH=$LD_LIBRARY_PATH
fi

sh startup.sh jpda
sleep 1
#Not sure if echo -e option is in mac. Bloody mac.

type fswatch >/dev/null 2>&1
if [ $? -eq 0 ]
then
    echo "Watching using fswatch"
    touch .class_modified
    fswatch -o ../../webapp/WEB-INF | xargs -n1 -I{} touch .class_modified  &
fi

echo ""
echo ""
echo "**********************************************************"
echo "Tailing catalina.out"
echo "**********************************************************"
tail -f ../logs/catalina.out ../logs/localhost.*.log
