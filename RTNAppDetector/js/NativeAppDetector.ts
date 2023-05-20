import type { TurboModule } from 'react-native/Libraries/TurboModule/RCTExport'
import { TurboModuleRegistry } from 'react-native'

export interface Spec extends TurboModule {
  isApp(name: string): Promise<boolean>
}

export default TurboModuleRegistry.get<Spec>('RTNAppDetector') as Spec | null
