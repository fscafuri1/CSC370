class RunLengthEncode:
    def Encode(uncode):
        encoded = ""
        numofchar = 1
        i = 0
        while i < len(uncode):
            if (i+1) == len(uncode) or uncode[i] != uncode[i+1]:
                encoded+=uncode[i]
                i+=1
            else:
                j = i+1
                while j<len(uncode):
                    p = j+1
                    if p == len(uncode) or uncode[j] != uncode[p]:
                        numofchar+=1
                        if numofchar <= 4:
                            q = 0
                            while q < numofchar:
                                encoded+=uncode[i]
                                q+=1
                            numofchar = 1
                            i=j+1
                            break
                        else:
                            if numofchar > 9:
                                encoded+= "/" + str(numofchar) + uncode[i]
                                i = j+1
                                numofchar = 1
                                break
                            else:
                                encoded+= "/0" + str(numofchar) + uncode[i]
                                i = j+1
                                numofchar = 1
                                break
                    elif uncode[i] == uncode[p]:
                        numofchar+=1
                        j+=1
        return encoded
    print("Please enter a string: ")
    str = input()
    print(Encode(str))
