import React from 'react'
import { useState } from 'react'
import { SafeAreaView, StatusBar, Text, Button } from 'react-native'
import RTNAppDetector from 'rtn-app-detector/js/NativeAppDetector'

const App: () => JSX.Element = () => {
  const [result, setResult] = useState<String | null>('Not Initialized')
  return (
    <SafeAreaView>
      <StatusBar barStyle={'dark-content'} />
      <Text style={{ marginLeft: 20, marginTop: 20 }}>
        3+7={result ?? '??'}
      </Text>
      <Button
        title="Compute"
        onPress={async () => {
          const value = await RTNAppDetector?.isAppInstalled(
            'com.instagram.android',
          )

          const list = await RTNAppDetector?.allAppsInstalled()

          console.log({ list, value })
          setResult(value ? 'True' : 'False')
        }}
      />
    </SafeAreaView>
  )
}
export default App
